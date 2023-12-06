package br.edu.up.app.ui.cliente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.up.app.databinding.FragmentListaClientesBinding
import br.edu.up.app.databinding.FragmentListaProdutosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClientesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListaClientesBinding.inflate(layoutInflater)

        //TODO: desenvolver...

        return binding.root
    }
}