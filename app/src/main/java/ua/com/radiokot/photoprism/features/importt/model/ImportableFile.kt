package ua.com.radiokot.photoprism.features.importt.model

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.net.Uri
import okio.Source
import okio.source
import ua.com.radiokot.photoprism.extension.checkNotNull

data class ImportableFile(
    val contentUri: Uri,
    val displayName: String,
    val mimeType: String?,
    val size: Long,
) {
    @SuppressLint("Recycle")
    fun source(contentResolver: ContentResolver): Source =
        contentResolver.openInputStream(contentUri)
            .checkNotNull { "Can't open input stream for $contentUri" }
            .source()
}
