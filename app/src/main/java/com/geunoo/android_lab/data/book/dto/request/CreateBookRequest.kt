package com.geunoo.android_lab.data.book.dto.request

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class CreateBookRequest(
    val review: String,
    @SerializedName("category_ids") val categoryIds: List<UUID>,
)
