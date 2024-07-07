package com.example.uas_pemograman_mobile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_pemograman_mobile.network.*
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE}
class MyViewModel: ViewModel() {

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    private val _inews = MutableLiveData<List<InewsItem>?> ()
    val inews: LiveData<List<InewsItem>?> = _inews

    private val _inew = MutableLiveData<InewsItem>()
    val inew: LiveData<InewsItem> = _inew

    private val _RumahSakits = MutableLiveData<List<RumahSakit>>()
    val RumahSakits: LiveData<List<RumahSakit>> = _RumahSakits

    private val _RumahSakit = MutableLiveData<RumahSakit>()
    val RumahSakit: LiveData<RumahSakit> = _RumahSakit

    private val _DataCovids = MutableLiveData<List<DataCovid19>>()
    val DataCovids: LiveData<List<DataCovid19>> = _DataCovids

    private  val _DataCovid = MutableLiveData<DataCovid19>()
    val DataCovid: LiveData<DataCovid19> = _DataCovid

    fun getInewsData() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _inews.value = InewsApi.retrofitServiceApi.getInews().articles
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _inews.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun getRumahSakitData() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _RumahSakits.value = RumahSakitApi.retrofitServiceApi.getRumahSakit()
                _status.value = ApiStatus.DONE
            } catch (e: java.lang.Exception) {
                _RumahSakits.value = listOf()
                _status.value = ApiStatus.ERROR

            }
        }
    }

    fun getUpdateData2() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _DataCovids.value = DataCovid19Api.retrofitServiceApi.getDataCovid19Data()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _DataCovids.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }
    fun onInewsClicked(inews: InewsItem) {
        _inew.value = inews
    }

    fun onRumahSakitClicked(rs: RumahSakit) {
        _RumahSakit.value = rs
    }

    fun onUpdateDataClicked(data: DataCovid19) {
        _DataCovid.value = data
    }
}


