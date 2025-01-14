package com.kieronquinn.app.smartspacer.ui.views.smartspace.templates

import android.content.Context
import android.view.View
import android.widget.RemoteViews
import com.kieronquinn.app.smartspacer.R
import com.kieronquinn.app.smartspacer.sdk.model.SmartspaceTarget
import com.kieronquinn.app.smartspacer.sdk.model.UiSurface
import com.kieronquinn.app.smartspacer.sdk.model.uitemplatedata.SubListTemplateData
import com.kieronquinn.app.smartspacer.sdk.model.uitemplatedata.Text

class ListTemplateSmartspaceView(
    targetId: String,
    override val target: SmartspaceTarget,
    override val template: SubListTemplateData,
    override val surface: UiSurface
): BaseTemplateSmartspaceView<SubListTemplateData>(targetId, target, template, surface) {

    override val layoutRes = R.layout.smartspace_view_template_list
    override val viewType = ViewType.TEMPLATE_LIST

    override fun apply(context: Context, textColour: Int, remoteViews: RemoteViews, width: Int) {
        super.apply(context, textColour, remoteViews, width)
        template.subListIcon?.let {
            remoteViews.setImageViewIcon(R.id.smartspace_view_list_icon, it.tintIfNeeded(textColour))
        }
        remoteViews.setOnClickAction(context, R.id.smartspace_view_list, template.subListAction)
        val item1 = template.subListTexts.getOrNull(0)
        remoteViews.setListItem(R.id.smartspace_view_list_item_1, item1, textColour)
        val item2 = template.subListTexts.getOrNull(1)
        remoteViews.setListItem(R.id.smartspace_view_list_item_2, item2, textColour)
        val item3 = template.subListTexts.getOrNull(2)
        remoteViews.setListItem(R.id.smartspace_view_list_item_3, item3, textColour)
    }

    private fun RemoteViews.setListItem(id: Int, item: Text?, textColour: Int) {
        val visibility = if(item != null){
            View.VISIBLE
        }else{
            View.GONE
        }
        setViewVisibility(id, visibility)
        setTextViewText(id, item?.text)
        setTextColor(id, textColour)
    }

}