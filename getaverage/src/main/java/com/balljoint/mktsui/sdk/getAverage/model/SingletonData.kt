package com.balljoint.mktsui.sdk.getAverage.model

class SingletonData private constructor() {

    private val mList: MutableList<Number> = mutableListOf()

    init {
        ++instancesCount
    }

    companion object {
        var instancesCount = 0
        private val mInstance: SingletonData = SingletonData()

        @Synchronized
        fun getInstance(): SingletonData {
            return mInstance
        }
    }

    fun addToList(value: Number) {
        mList.add(value)
    }

    fun getList(): MutableList<Number> {
        return this.mList
    }

}