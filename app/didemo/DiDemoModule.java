package didemo;

import com.commercetools.sunrise.common.contexts.RequestScoped;
import com.google.inject.AbstractModule;

public class DiDemoModule extends AbstractModule {
    @Override
    protected void configure() {
        // CLASS
//        bind(InjectionSubject.class).in(Singleton.class);
        bind(InjectionSubject.class).in(RequestScoped.class);

        // SUBCLASS
//        bind(SubclassInjectionSubject.class).in(Singleton.class);
        bind(SubclassInjectionSubject.class).in(RequestScoped.class);
    }
}

/**
 * Request Scope - instantiates the class on every request.
 * Singleton - only once
 * default scope -> prototype scope
 */
