package th.ac.su.ict.ponpitak.simpleloancalculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter


var itemList:ArrayList<Promotion> = ArrayList<Promotion>()
lateinit var arrayAdapter: ArrayAdapter<Promotion>

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)


    var jsonFileString = getJsonDataFromAsset(applicationContext,"promotion.json")

    val gson = Gson()
    val listItemType = object :TypeToken<ArrayList<Promotion>>(){}.type

    var foodList : ArrayList<Promotion> = gson.fromJson(jsonFileString,listItemType)

//        Log.i("data",foodList[0].Foodname)

    itemList = foodList
    val adapter = Promotion(this@PromotionActivity,itemList)

    listView.adapter = adapter

    listView.setOnItemClickListener { parent, view, position, id ->

        var intent = Intent(this@MainActivity,DetailActivity::class.java)

        intent.putExtra("title",itemList[position].Foodname)
        intent.putExtra("caption",itemList[position].Descript)
        intent.putExtra("imageFiLe",itemList[position].Imagesfile)
        intent.putExtra("shopName",itemList[position].Shopname)
        intent.putExtra("rate",itemList[position].Popular)

        startActivity(intent)

    }

}