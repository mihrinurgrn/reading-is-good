package com.mng.bookorderproject.domain;

import java.io.Serializable;

public interface BusinessValidationRule extends Serializable {
    String getCode();

    String getDescription();
}
