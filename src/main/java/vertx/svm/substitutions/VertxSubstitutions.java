package vertx.svm.substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import io.netty.handler.ssl.SslContext;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.JdkLoggerFactory;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.net.impl.transport.Transport;

import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;



@TargetClass(io.netty.util.internal.logging.InternalLoggerFactory.class)
final class Target_io_netty_util_internal_logging_InternalLoggerFactory {
    @Substitute
    private static InternalLoggerFactory newDefaultFactory(String name) {
        return JdkLoggerFactory.INSTANCE;
    }
}

@TargetClass(io.vertx.core.net.impl.transport.Transport.class)
final class Target_io_vertx_core_net_impl_transport_Transport {
    @Substitute
    public static Transport nativeTransport() {
        return null;
    }
}


@TargetClass(io.vertx.core.net.impl.SSLHelper.class)
final class Target_io_vertx_core_net_impl_SSLHelper {

    @Substitute
    private SslContext createContext(VertxInternal vertx, X509KeyManager mgr, TrustManagerFactory trustMgrFactory) {
        return null;
    }

}

public class VertxSubstitutions {
}
