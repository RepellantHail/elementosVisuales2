package com.example.elementosvisuales2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class PopupActivity : AppCompatActivity() {

    private lateinit var popupMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        popupMenu = findViewById(R.id.activity_main_popup)

        popupMenu.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?) {
                val menu = PopupMenu(this@PopupActivity, view)
                val inflater: MenuInflater = menu.getMenuInflater()
                inflater.inflate(R.menu.activity_main_menu,menu.getMenu())

                menu.setOnMenuItemClickListener(object : MenuItem.OnMenuItemClickListener,
                    PopupMenu.OnMenuItemClickListener {
                    override fun onMenuItemClick(menuItem: MenuItem): Boolean {
                        return when (menuItem.itemId){
                            R.id.new_game -> {
                                mostrar_mensaje("Nuevo Juego desde Menu Popup")
                            }
                            R.id.help->{
                                mostrar_mensaje("Ayuda desde Menú Popup")
                            }
                            else->false
                        }
                    }
                    })
                menu.show()
            }
        })

    }

    fun mostrar_mensaje(msj:String):Boolean{
        val toast = Toast.makeText(this,msj, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER,0,0)
        toast.show()
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.new_game->{ mostrar_mensaje("Nuevo juego desde Menú de Opciones Contextual") }
            R.id.help->{ mostrar_mensaje("Ayuda desde Menú de Opciones Contextual") }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.activity_main_menu,menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.activity_main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.new_game -> mostrar_mensaje("Nuevo juego desde Menú de Opciones")
            R.id.help -> mostrar_mensaje("Ayuda desde Menú Opciones")
            else -> super.onOptionsItemSelected(item)
        }
    }

}