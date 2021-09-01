package com.codingwithmitch.navigationcomponentsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import kotlinx.android.synthetic.main.fragment_specify_amount.*
class SpecifyAmountFragment : Fragment(), View.OnClickListener {
    private val args: SpecifyAmountFragmentArgs by navArgs()
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specify_amount , container , false)
    }
    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        this.navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.send_btn -> {
                val count = "thong tin nguoi mua:" + args.name + "-" + input_amount.text.toString()
                val action =
                    SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(
                        count)
                findNavController().navigate(action)
            }
        }
    }
}




