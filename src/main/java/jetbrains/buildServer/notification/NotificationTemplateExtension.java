package jetbrains.buildServer.notification;

import jetbrains.buildServer.serverSide.BuildPromotionEx;
import jetbrains.buildServer.serverSide.SBuild;
import jetbrains.buildServer.vcs.SelectPrevBuildPolicy;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class NotificationTemplateExtension implements TemplateProcessor {

    @NotNull
    public Map<String, Object> fillModel(@NotNull NotificationContext context) {
        Map<String, Object> model = new HashMap<String, Object>();
        final SBuild build = (SBuild) context.getCurrentModel().get("build");
        if (build != null) {
            model.put("build_allChanges", ((BuildPromotionEx) build.getBuildPromotion()).getDetectedChanges(SelectPrevBuildPolicy.SINCE_LAST_BUILD, true));
        }
        return model;
    }
}