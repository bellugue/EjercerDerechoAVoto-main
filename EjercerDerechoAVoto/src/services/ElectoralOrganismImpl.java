package services;

import data.Nif;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.NotEnabledException;

import java.net.ConnectException;
import java.util.HashMap;

public class ElectoralOrganismImpl implements ElectoralOrganism{
    boolean connectionError = false;
    HashMap<Nif, Boolean> counts;

    public ElectoralOrganismImpl() throws NifIsNullException, NifNotValidException {
        counts = new HashMap<>();
        Nif nif1 = new Nif("11111111a");
        counts.put(nif1, false);
        Nif nif2 = new Nif("22222222a");
        counts.put(nif2, false);
        Nif nif3 = new Nif("33333333a");
        counts.put(nif3, false);
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
        for(Nif countNif : counts.keySet()){
            if(countNif.getNif().equals(nif.getNif())){
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

        counts.replace(nif, false, true);
    }

    @Override
    public void setConnectionError() {
        this.connectionError = true;
    }

}
