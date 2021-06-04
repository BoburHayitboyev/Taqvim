package uz.ramazon.taqvim2021.ramazontaqvim2021.ui.activity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import uz.ramazon.taqvim2021.ramazontaqvim2021.R
import uz.ramazon.taqvim2021.ramazontaqvim2021.adapter.ItemAdapter
import uz.ramazon.taqvim2021.ramazontaqvim2021.databinding.FragmentMainBinding
import uz.ramazon.taqvim2021.ramazontaqvim2021.model.Item

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var items = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        val itemAdapter = ItemAdapter(
            items = items, itemClickListener = ItemAdapter.ItemClickListener {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("${it.sana}dagi taqvim:")

                builder.setMessage("Saharlik: ${it.saharlik}\nIftorlik ${it.iftorlik}")

                builder.setIcon(R.drawable.calendar)

                val alertDialog: AlertDialog = builder.create()

                alertDialog.show()
            }
        )
        items.add(Item("13-Aprel", "Seshanba","04:25", "19.03"))
        items.add(Item("14-Aprel","Chorshanba", "04:24", "19.04"))
        items.add(Item("15-Aprel","Payshanba", "04:22", "19.05"))
        items.add(Item("16-Aprel","Juma", "04:20", "19.06"))
        items.add(Item("17-Aprel","Shanba", "04:18", "19.07"))
        items.add(Item("18-Aprel","Yakshanba", "04:16", "19.08"))
        items.add(Item("19-Aprel","Dushanba", "04:14", "19.09"))
        items.add(Item("20-Aprel", "Seshanba", "04:13", "19.10"))
        items.add(Item("21-Aprel","Chorshanba", "04:11", "19.11"))
        items.add(Item("22-Aprel","Payshanba", "04:09", "19.13"))
        items.add(Item("23-Aprel","Juma", "04:07", "19.14"))
        items.add(Item("24-Aprel","Shanba", "04:05", "19.15"))
        items.add(Item("25-Aprel","Yakshanba", "04:04", "19.16"))
        items.add(Item("26-Aprel","Dushanba", "04:02", "19.17"))
        items.add(Item("27-Aprel", "Seshanba", "04:00", "19.18"))
        items.add(Item("28-Aprel","Chorshanba", "03:58", "19.19"))
        items.add(Item("29-Aprel","Payshanba", "03:57", "19.20"))
        items.add(Item("30-Aprel","Juma", "03:55", "19.21"))
        items.add(Item("1-May","Shanba", "03:53", "19.22"))
        items.add(Item("2-May","Yakshanba", "03:51", "19.23"))
        items.add(Item("3-May","Dushanba", "03:50", "19.24"))
        items.add(Item("4-May", "Seshanba", "03:48", "19.25"))
        items.add(Item("5-May","Chorshanba", "03:46", "19.26"))
        items.add(Item("6-May","Payshanba", "03:45", "19.27"))
        items.add(Item("7-May","Juma", "03:43", "19.28"))
        items.add(Item("8-May","Shanba", "03:42", "19.29"))
        items.add(Item("9-May","Yakshanba", "03:40", "19.31"))
        items.add(Item("10-May","Dushanba", "03:39", "19.32"))
        items.add(Item("11-May", "Seshanba", "03:37", "19.33"))
        items.add(Item("12-May","Chorshanba", "03:36", "19.34"))

        itemAdapter.notifyDataSetChanged()

        binding.recyclerView.apply {
            adapter = itemAdapter
            setHasFixedSize(true)
        }

        return binding.root
        }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}