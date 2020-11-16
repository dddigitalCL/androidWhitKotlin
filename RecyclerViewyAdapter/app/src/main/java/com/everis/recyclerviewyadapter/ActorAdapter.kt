package com.everis.recyclerviewyadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

data class ActorAdapter (val actorInstanciada:List<ActorMovie>):RecyclerView.Adapter<ActorAdapter.ActorHolder>(){
    //<ActorAdapter> hace referencia al nombre de la clase que se encargara de hacer la adapt.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActorHolder(layoutInflater.inflate(R.layout.item_actor, parent , false))
                                                                //Se encarga de crear el viewHolder cuando se necesite
                                                                //layoutInflater para crear una instancia, pero necesita el contexto
                                                                //retornamos la clase ActorHolder y le asignamos La carpeta de Layout
                                                                //donde tenemos la vista res>layout>xml.
                                                                //Agregamos la instancia de viewGroup y viewType como false.
    }

    override fun getItemCount(): Int {                           //Este método le indica al RecyclerView cuantos Items contiene.
       return actorInstanciada.size                              //la funcion se puede hacer más sencilla de la siguiente forma
                                                                 // "override fun getItemCount(): Int = actorInstanciada.size"
    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.render(actorInstanciada[position])                //Este método se encarga de avisar y devolver una nueva posición.
                                                                 //La instancia holder. hará lo que nuestra clase ActorHolder señale
    }


    class ActorHolder(val view:View):RecyclerView.ViewHolder(view){
        val nombrePeli = view.findViewById(R.id.tvMovie) as TextView
        val actorPeli = view.findViewById(R.id.tvActor) as TextView
        val nombreActor = view.findViewById(R.id.tvRealName) as TextView
        val lanzamiento = view.findViewById(R.id.tvReleaseYear) as TextView
        val image =view.findViewById(R.id.ivImageActor) as ImageView

        fun render(actorInstanciada: ActorMovie){               // View corresponde a la vista de res>layou>item_actor.
            nombrePeli.text = actorInstanciada.movieName
            actorPeli.text = actorInstanciada.mainActor
            nombreActor.text = actorInstanciada.realName
            lanzamiento.text = actorInstanciada.releaseYear
            Picasso.get().load(actorInstanciada.image).into(image)
            itemView.setOnClickListener(View.OnClickListener{ Toast.makeText(view.context, "Pelicula seleccionada ${actorInstanciada.movieName}", Toast.LENGTH_SHORT).show() })

            //image.loadUrl(actorInstanciada.image)
        }


        /*    NO ME FUNCIONO ESTA FUNCIÓN DEL EJEMPLO
      fun ImageView.loadUrl(url:String){
           Picasso.with(context).load(url).into(this)
       }*/


    }

}