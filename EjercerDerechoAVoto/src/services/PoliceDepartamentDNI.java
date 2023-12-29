package services;

import data.Nif;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;

import java.util.ArrayList;
import java.util.List;

public class PoliceDepartamentDNI implements PoliceDepartament {

    private List<Nif> validDNI;

    public PoliceDepartamentDNI() throws NifIsNullException, NifNotValidException {
        validDNI = new ArrayList<>();
        validDNI.add(new Nif("11111111a"));
        validDNI.add(new Nif("22222222a"));
        validDNI.add(new Nif("33333333a"));
    }

    @Override
    public boolean isDNIValid(Nif nif) {
        for(Nif current : validDNI){
            if(current.equals(nif)){
                return true;
            }
        }
        return false;
    }
}
