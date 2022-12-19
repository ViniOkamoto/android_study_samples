package com.example.motivation.`interface`

import com.example.motivation.core.utils.AppConstants

interface FilterInterface {
    val filterId: Int
    val categoryId: Int
}

class AllFilter (id: Int) : FilterInterface {
    override val filterId: Int = id
    override val categoryId: Int = AppConstants.FILTERS.ALL
}

class SunnyFilter(id: Int) : FilterInterface {
    override val filterId: Int = id
    override val categoryId: Int = AppConstants.FILTERS.SUNNY
}

class HappyFilter (id: Int) : FilterInterface {
    override val filterId: Int = id
    override val categoryId: Int = AppConstants.FILTERS.HAPPY
}
