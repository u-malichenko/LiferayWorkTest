package com.test.wrapper;
//
//import com.liferay.portal.kernel.resource.bundle.AggregateResourceBundleLoader;
//import com.liferay.portal.kernel.resource.bundle.CacheResourceBundleLoader;
//import com.liferay.portal.kernel.resource.bundle.ClassResourceBundleLoader;
//import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
//import com.liferay.portal.kernel.service.ServiceWrapper;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//
//import java.util.Locale;
//import java.util.ResourceBundle;
//
//
//@Component(
//        property = {
//                "bundle.symbolic.name=com.liferay.message.boards.web",
//                "resource.bundle.base.name=content.Language",
//                "servlet.content.name=message-boards-web",
//        },
//       // service = ResourceBundle.class
//        service = ServiceWrapper.class
//)
//public class MyCustomLanguages implements  ResourceBundleLoader{
//
//    private AggregateResourceBundleLoader bundle;
//
//    @Reference(target = "(bundle.symbolic.name=com.liferay.message.boards.web)")
//    public void setResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {
//        bundle = new AggregateResourceBundleLoader(new CacheResourceBundleLoader(new ClassResourceBundleLoader(
//                "content.Language", MyCustomLanguages.class.getClassLoader())), resourceBundleLoader);
//    }
//
//    @Override
//    public ResourceBundle loadResourceBundle(Locale locale) {
//        return bundle.loadResourceBundle(locale);
//    }
//}
