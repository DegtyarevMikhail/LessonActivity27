package com.example.lessonactivity27

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonactivity27.databinding.CardItemBinding



class CardAdapter(val listener: Listener) : RecyclerView.Adapter<CardAdapter.CardHolder>() {
    val cardList = ArrayList<Card>()


    class CardHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = CardItemBinding.bind(item)


        fun bind(card: Card, listener: Listener) = with(binding){
            im.setImageResource(card.imageId)
            tvTitle.text = card.title
            itemView.setOnClickListener{
                listener.onClick(card)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardHolder(view)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(cardList[position], listener)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    fun addCard(card: Card){
        cardList.add(card)
        notifyDataSetChanged()
    }
    interface Listener{
        fun onClick(card:Card)
    }

 /*   fun addAll(list: List<Card>){
        cardList.clear()
        cardList.addAll(list)
        notifyDataSetChanged()
    }
  */
}