package com.example.bankasiaapp.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankasiaapp.R
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {
    private val usersListAdapter = UserListAdapter(arrayListOf())

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_account, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        dashboardViewModel.refresh()

        userList.apply {
            layoutManager = LinearLayoutManager(context)
            // adapter = dogsListAdapter
        }
        refreshlayout.setOnRefreshListener {
            userList.visibility = View.GONE
            listError.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
            dashboardViewModel.refresh()
            refreshlayout.isRefreshing = false
        }
        observeViewModel()
    }

    fun observeViewModel() {
        dashboardViewModel.user.observe(viewLifecycleOwner, Observer { users ->
            users?.let {
                userList.visibility = View.VISIBLE
                usersListAdapter.updateUserList(users)
            }
        })

        dashboardViewModel.userLoadError.observe(viewLifecycleOwner, Observer { isError ->
            isError?.let {
                listError.visibility = if (it) View.VISIBLE else View.GONE
            }
        })

        dashboardViewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            isLoading?.let {
                loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    listError.visibility = View.GONE
                    userList.visibility = View.GONE
                }
            }
        })

    }

}