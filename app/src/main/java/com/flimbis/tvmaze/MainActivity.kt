package com.flimbis.tvmaze

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.flimbis.tvmaze.adapter.ShowsAdapter
import com.flimbis.tvmaze.di.component.DaggerShowsComponent
import com.flimbis.tvmaze.di.component.ShowsComponent
import com.flimbis.tvmaze.di.module.ShowsModule
import com.flimbis.tvmaze.model.Show
import com.flimbis.tvmaze.tv.shows.ShowsPresenter
import com.flimbis.tvmaze.tv.shows.ViewContract
import com.flimbis.tvmaze.tv.shows.detail.ShowsDetailActivity
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.longToast
import java.io.Serializable
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ViewContract.View {
    val DEF_THEME = "def"
    val CINEMA_THEME = "cinema"

    @Inject
    lateinit var presenter: ShowsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //theme
        setTheme(getSavedTheme())
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = "TvAmaze"

        //dagger component
        showsComponent().inject(this)

        presenter.loadShows(1)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbind()
    }

    override fun displayShows(shows: List<Show>) {
        val adapter = ShowsAdapter(shows) { presenter.navigateToDetails(it) }//use "it" where parameter is one
        shows_grid.layoutManager = GridLayoutManager(this, 3)
        shows_grid.adapter = adapter
    }

    override fun showDetails(show: Show) {
        val intnt = Intent(this, ShowsDetailActivity::class.java)
        intnt.putExtra("TvShow", show as Serializable)
        startActivity(intnt)
    }

    override fun showEmptyView() {
    }

    override fun showMessage(message: String) {
        longToast(message)//extension function provided by anko
    }

    fun showsComponent(): ShowsComponent {
        val component: ShowsComponent = DaggerShowsComponent.builder()
                .showsModule(ShowsModule(this))
                .appComponent(TvApplication.getInstance().getAppComponent())
                .build()
        return component
    }

    fun saveTheme(value: String){
        val editor: SharedPreferences.Editor = getPreferences(0).edit()
        editor.putString("theme", value)
        editor.commit()
        recreate()
    }

    fun getSavedTheme(): Int {
        val theme: String = getPreferences(0).getString("theme",DEF_THEME)
        val value: Int
        when(theme){
            DEF_THEME-> value = R.style.AppTheme_Def
            CINEMA_THEME -> value = R.style.AppTheme_Cinema
            else -> value = R.style.AppTheme_Cinema
        }

        return value
    }
}
