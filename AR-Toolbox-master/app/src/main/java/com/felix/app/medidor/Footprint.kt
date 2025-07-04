package com.felix.app.medidor

import android.content.Context
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.BaseTransformableNode
import com.google.ar.sceneform.ux.SelectionVisualizer

class Footprint(context: Context) : SelectionVisualizer {

    interface Invisible

    private val node: Node = Node()

    var isEnabled: Boolean
        get() = node.isEnabled
        set(value) {
            node.isEnabled = value
        }

    init {
        ModelRenderable.builder()
            .setSource(context, com.google.ar.sceneform.ux.R.raw.sceneform_footprint)
            .build()
            .thenAccept {
                it.collisionShape = null
                node.renderable = it.apply { collisionShape = null }
            }
    }

    override fun applySelectionVisual(node: BaseTransformableNode) {
        when (node) {
            is Invisible -> return
            else -> this.node.setParent(node)
        }
    }

    override fun removeSelectionVisual(node: BaseTransformableNode) {
        when (node) {
            is Invisible -> return
            else -> this.node.setParent(null)
        }
    }
}
