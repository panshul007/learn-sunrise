package bettertitles;

import com.commercetools.sunrise.common.pages.PageData;
import com.commercetools.sunrise.framework.ControllerComponent;
import com.commercetools.sunrise.hooks.PageDataHook;
import com.commercetools.sunrise.productcatalog.home.HomePageContent;
import io.sphere.sdk.models.Base;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * 1. put new title into the page
 * 2. wire in the component to all controllers
 */
public class BetterTitlesComponent extends Base implements ControllerComponent, PageDataHook {
    public static final String SUNRISE_DEMO_SHOP = "Sunrise Demo Shop";

    private static String deduceNewTitle(final PageData pageData) {
        final String title = defaultIfNull(pageData.getHeader().getTitle(), "");
        final String newTitle;
        if (pageData.getContent() instanceof HomePageContent) {
            newTitle = SUNRISE_DEMO_SHOP + " Home";
        } else if (!isEmpty(title)){
            newTitle = title + " ~ " + SUNRISE_DEMO_SHOP;
        } else {
            newTitle = SUNRISE_DEMO_SHOP;
        }
        return newTitle;
    }

    @Override
    public void acceptPageData(PageData pageData) {
        pageData.getHeader().setTitle(deduceNewTitle(pageData));
    }
}
