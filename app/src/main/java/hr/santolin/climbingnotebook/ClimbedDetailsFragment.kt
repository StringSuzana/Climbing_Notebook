package hr.santolin.climbingnotebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_climbed_details.*


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ROUTE_NAME = "routeName"
private const val MOUNTAIN = "mountain"

/**
 * A simple [Fragment] subclass.
 * Use the [ClimbedDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClimbedDetailsFragment : Fragment() {
    private var routeName: String? = null
    private var mountain: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            routeName = it.getString(ROUTE_NAME)
            mountain = it.getString(MOUNTAIN)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_climbed_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvRouteNameDetails.text = routeName
        tvMountainDetails.text = mountain
    }

    companion object {
        /**
         * @param routeName Parameter 1.
         * @param mountain Parameter 2.
         * @return A new instance of fragment ClimbedDetailsFragment.
         */

        @JvmStatic
        fun newInstance(routeName: String, mountain: String) =
            ClimbedDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ROUTE_NAME, routeName)
                    putString(MOUNTAIN, mountain)
                }

            }

    }
}