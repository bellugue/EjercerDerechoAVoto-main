package services;

import data.Nif;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.NotEnabledException;

import java.net.ConnectException;
import java.util.HashMap;

public class ElectoralOrganismImpl implements ElectoralOrganism{
    boolean connectionError = false;
    HashMap<String, Boolean> counts;

    public ElectoralOrganismImpl() throws NifIsNullException, NifNotValidException {
        counts = new HashMap<>();
        counts.put("11111111a", false);
        counts.put("22222222a", false);
        counts.put("33333333a", false);
    }

    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {
        if(connectionError){
            throw new ConnectException("Connection error to Electoral Organism");
        }

        if(isEnabledInElectoralOrganism(nif)){
            System.out.println("L'usuari amb nif " + nif.getNif() + " pot votar.");
        }
        else
            throw new NotEnabledException("User with nif " + nif.getNif() + " is not allowed in this electoral organism");
    }

    private boolean isEnabledInElectoralOrganism(Nif nif) {
        for(String countNif : counts.keySet()){
            if(countNif.equals(nif.getNif())){
                if(counts.get(countNif) == false){
                    return true;
                }
                break;
            }
        }
        return false;
    }

    @Override
    public void disableVoter(Nif nif) throws ConnectException {
        if(connectionError){
            throw new ConnectException("Connection error to Electoral Organism");
        }
        counts.put(nif.getNif(), true);
        System.out.println("A");
    }

    @Override
    public void setConnectionError() {
        this.connectionError = true;
    }

}
