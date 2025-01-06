package mylist;

import java.security.PublicKey;

public class PosIllegal extends RuntimeException{
    public PosIllegal(String msg) {
        super(msg);
    }
}
