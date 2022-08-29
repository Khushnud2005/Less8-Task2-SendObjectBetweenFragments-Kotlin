package uz.exemple.less8_task2_kotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import uz.exemple.less8_task2_kotlin.R
import uz.exemple.less8_task2_kotlin.model.UserModel

class FirstFragment:Fragment() {

    var listener: FirstListener? = null
    var textView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.first_fragment, container, false)
        initViews(view)
        return view
    }

    fun initViews(view: View) {
        textView = view.findViewById(R.id.tv_firstFrag)
        val user = UserModel("Xushnud", "abc@def.com", "911234567")
        val btn_first = view.findViewById<Button>(R.id.btn_firstFrag)
        btn_first.setOnClickListener {
            listener!!.sendFirst(user)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = if (context is FirstListener) {
            context
        } else {
            throw RuntimeException("$context You mast init listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

   public fun updateFirstText(user: UserModel) {
        textView!!.setText(user.toString())
    }


   public interface FirstListener {
        fun sendFirst(user: UserModel)
    }
}