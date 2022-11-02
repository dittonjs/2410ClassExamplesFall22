package com.usu.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.usu.recyclerview.databinding.ContactListItemBinding

var count = 0

class ContactsAdapter(private val contacts: List<Contact>, private val onClick: (Contact) -> Unit = {}): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    class ViewHolder(val binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        count++
        println(count)
        val binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("NEW VIEW BOUND AT POSITION $position")
        val contact = contacts[position]
        holder.binding.nameTextView.text = contact.name
        holder.binding.phoneNumberTextView.text = contact.phoneNumber
        holder.binding.emailTextView.text = contact.email
        holder.binding.root.setOnClickListener() {
            onClick(contact)
        }

    }

    over
}