package th.ac.su.ict.ponpitak.simpleloancalculator.Data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_list.view.*
import th.ac.su.ict.ponpitak.simpleloancalculator.R

class ProAdapter(private val context: Context,
                 private val dataSource:ArrayList<Promotion>) : BaseAdapter(){


    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        val rowView = inflater.inflate(R.layout.activity_list,null)

        rowView.topicPro.text = dataSource[position].promo_name
        rowView.detailPro.text = dataSource[position].promo_description
        rowView.promoCode.text = dataSource[position].promo_code.toString()


        //rowView.imgThumbnail.setImageResource(R.drawable.monster01_tn)

        val res = context.resources
        val drawableId:Int =
                res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)

        rowView.imgThumbnail.setImageResource(drawableId)

        return rowView
    }

    override fun getItem(position: Int): Any {

        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    override fun getCount(): Int {

        return  dataSource.size
    }

}

