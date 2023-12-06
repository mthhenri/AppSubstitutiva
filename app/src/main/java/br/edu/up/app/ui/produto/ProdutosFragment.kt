package br.edu.up.app.ui.produto

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import br.edu.up.app.R
import br.edu.up.app.data.BancoSQLite
import br.edu.up.app.data.ProdutoRepository
import br.edu.up.app.databinding.FragmentListaProdutosBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProdutosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Injeção automática de dependência
        val viewModel : ProdutoViewModel by activityViewModels()

        val binding = FragmentListaProdutosBinding.inflate(layoutInflater)
        val recyclerView = binding.listProdutos

        binding.fabProdutos.setOnClickListener { view ->
            viewModel.novo()
            //Action safeArgs
            val action = ProdutosFragmentDirections.actionNavHomeToProdutoFragment()
            //Nav controller
            findNavController().navigate(action)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.produtos.collect{ produtos ->
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = ProdutosAdapter(produtos, viewModel)
                }
            }
        }
        return binding.root
    }
}