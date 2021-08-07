import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.danielalaye.superherolist.Models.Superhero
import com.danielalaye.superherolist.R
import com.squareup.picasso.Picasso

//Un adapter es la clase que hace de puente entre la vista (el recyclerview) y los datos (lista de super heroes).
//La clase RecyclerAdapter se encargará de recorrer la lista de superhéroes que le pasamos, y llamando a otra clase interna (ViewHolder), este rellenará los campos.

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var superheros: MutableList<Superhero>  = ArrayList()
    lateinit var context:Context

    // es un simple constructor (tiene el mismo nombre que la clase y lo único que hará será recibir la lista y el contexto que le pasamos desde la clase principal)
    fun RecyclerAdapter(superheros : MutableList<Superhero>, context: Context){
        this.superheros = superheros
        this.context = context
    }

    //métodos obligatorios que se implementan de la clase RecyclerView.

    //onBindViewHolder() se encarga de coger cada una de las posiciones de la lista de superhéroes y pasarlas a la clase ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheros.get(position)
        holder.bind(item, context)
    }

    //onCreateViewHolder() que como su nombre indica lo que hará será devolvernos un objeto ViewHolder al cual le pasamos la celda que hemos creado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_superhero_list, parent, false))
    }

    //getItemCount() nos devuelve el tamaño de la lista, que lo necesita el RecyclerView.
    override fun getItemCount(): Int {
        return superheros.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // view.findViewByID() busca los items a través de la id que le ponemos, y luego añadimos el as X donde X es el tipo del componente (ImageView, TextView…)
        val superheroName = view.findViewById(R.id.tvSuperhero) as TextView
        val realName = view.findViewById(R.id.tvRealName) as TextView
        val publisher = view.findViewById(R.id.tvPublisher) as TextView
        val avatar = view.findViewById(R.id.ivAvatar) as ImageView

        //bind: dicho método lo llamamos desde el onBindViewHolder() para que rellene los datos
        fun bind(superhero:Superhero, context: Context){

            //añadir todos los textos que queremos
            superheroName.text = superhero.superhero
            realName.text = superhero.realName
            publisher.text = superhero.publisher

            //llamamos a itemView que es la vista (celda) que estamos rellenando y le ponemos un setOnClickListener que
            //pintará en pantalla el nombre del superhéroe en el que hemos hecho click.
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, superhero.superhero, Toast.LENGTH_SHORT).show() })

            // seleccionamos el ImageView y con el método que hemos creado le pasamos la URL de la imagen.
            // Esta url la usará Picasso para descargarla de internet y pintarla en nuestra lista
            avatar.loadUrl(superhero.photo)
        }
        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }

}