package masarifyuli.co.id.javaspring.security.model;

import java.util.List;

public interface AuthUserDetailsCompatible {

    default AuthUserDetails toAuthUserDetails() {
        return toAuthUserDetails();
    }

    public AuthUserDetails toAuthUserDetails(List<String> roles);

}
