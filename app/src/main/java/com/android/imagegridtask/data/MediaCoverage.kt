package com.android.imagegridtask.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MediaCoverage(
    @SerializedName("id")
    @Expose
    var id: String? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("language")
    @Expose
    var language: String? = null,

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: Thumbnail? = null,

    @SerializedName("mediaType")
    @Expose
    var mediaType: Int? = null,

    @SerializedName("coverageURL")
    @Expose
    var coverageURL: String? = null,

    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String? = null,

    @SerializedName("publishedBy")
    @Expose
    var publishedBy: String? = null,

    @SerializedName("backupDetails")
    @Expose
    var backupDetails: BackupDetails? = null
) {
    fun getThumbnailUrl(): String {
        return "${thumbnail?.domain}/${thumbnail?.basePath}/0/${thumbnail?.key}"
    }

    data class Thumbnail(
        @SerializedName("id")
        @Expose
        var id: String? = null,

        @SerializedName("version")
        @Expose
        var version: Int? = null,

        @SerializedName("domain")
        @Expose
        var domain: String? = null,

        @SerializedName("basePath")
        @Expose
        var basePath: String? = null,

        @SerializedName("key")
        @Expose
        var key: String? = null,

        @SerializedName("qualities")
        @Expose
        var qualities: List<Int>? = null,

        @SerializedName("aspectRatio")
        @Expose
        var aspectRatio: Double? = null
    )
    data class BackupDetails(
        @SerializedName("pdfLink")
        @Expose
        var pdfLink: String? = null,

        @SerializedName("screenshotURL")
        @Expose
        var screenshotURL: String? = null
    )
}
