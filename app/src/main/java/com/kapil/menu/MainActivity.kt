package com.kapil.menu
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {
    var listOfFoods=ArrayList<Food>()
    var adapter:FoodAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOfFoods.add(Food("Coffee","Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. From the coffee fruit, the seeds are separated to produce a stable, raw product: unroasted green coffee. The seeds are then roasted, a process which transforms them into a consumable product: roasted coffee, which is ground into a powder and typically steeped in hot water before being filtered out, producing a cup of coffee.",R.drawable.coffee_pot));
        listOfFoods.add(Food("Espersso","Espresso is a coffee-brewing method of Italian origin, in which a small amount of nearly boiling water is forced under 9–10 bars of pressure through finely-ground coffee beans. Espresso coffee can be made with a wide variety of coffee beans and roast degrees.",R.drawable.espresso))
        listOfFoods.add(Food("French Fries","French fries, chips, finger chips, French-fried potatoes, or simply fries are batonnet or allumette-cut deep-fried potatoes, originating from either Belgium or France. They are prepared by cutting the potato into even strips, then drying and frying it, usually in a deep fryer",R.drawable.french_fries))
        listOfFoods.add(Food("Honey","Honey is a sweet, viscous food substance made by honey bees and some related insects, such as stingless bees. Bees produce honey from the sugary secretions of plants or from secretions of other insects, by regurgitation, enzymatic activity, and water evaporation",R.drawable.honey))
        listOfFoods.add(Food("Strawberry","The garden strawberry is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries, which are cultivated worldwide for their fruit. The fruit is widely appreciated for its characteristic aroma, bright red color, juicy texture, and sweetness",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar Cubes","Sugar cube, sugar pressed together in block shape that is used to sweeten drinks",R.drawable.sugar_cubes))
        adapter=FoodAdapter(this,listOfFoods)
        gvListFood.adapter=adapter

    }
    class FoodAdapter: BaseAdapter
    {
        var listOfFood=ArrayList<Food>()
        var context: Context? = null

        constructor(context:Context,listOfFood:ArrayList<Food>):super()
        {
         this.context=context
            this.listOfFood=listOfFood
        }
        override fun getCount(): Int {
           return listOfFood.size
        }

        override fun getItem(p0: Int): Any {
        return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

       var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val food=this.listOfFood[p0]
            var foodView=inflator.inflate(R.layout.food_ticket,null)
                foodView.ivFoodImage.setImageResource(food.image!!)
                foodView.ivFoodImage.setOnClickListener()
            {
                val intent= Intent(context,foodDetails::class.java)
                intent.putExtra("name",food.name,)
                intent.putExtra("des",food.des)
                intent.putExtra("image",food.image)
                context!!.startActivity(intent)
            }
                foodView.tvName.text=food.name


        return foodView     }

    }
}


