package services;

import data.VotingOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScrutinyImpl implements Scrutiny{
    HashMap<VotingOption, Integer> votation;
    int nullVotes;
    int blankVotes;

    public ScrutinyImpl(){
        votation = new HashMap<>();
        nullVotes = 0;
        blankVotes = 0;
    }
    @Override
    public void initVoteCount(List<VotingOption> validParties) {
        for(VotingOption option : validParties){
            votation.put(option, 0);
        }
    }

    @Override
    public void scrutinize(VotingOption vopt) {

        if(vopt == null){
            blankVotes++;
            return;
        }

        if(votation.containsKey(vopt)){
            int numVotes = votation.get(vopt);
            votation.replace(vopt, numVotes+1);
        }
        else{
            nullVotes++;
        }

    }

    @Override
    public int getVotesFor(VotingOption vopt) {
        if(vopt == null){
            return 0; //S'ha de mirar lo que es vol fer si no es passa cap partit
        }
        if(votation.containsKey(vopt)){
            return votation.get(vopt);
        }
        else{
            return 0; //S'ha de mirar lo que es vol fer aqui, si es retorna 0 a un partit que no existeix o que
        }
    }

    @Override
    public int getTotal() {
        int total = 0;
        for(VotingOption option : votation.keySet()){
            total += votation.get(option);
        }
        return total;
    }

    @Override
    public int getNulls() {
        return nullVotes;
    }

    @Override
    public int getBlanks() {
        return blankVotes;
    }

    @Override
    public void getScrutinyResults() {
        for(VotingOption option : votation.keySet()){
            int numvotes = votation.get(option);
            System.out.println(option.toString() + " - " + numvotes + " votes.");
        }
        System.out.println("Null votes : " + nullVotes);
        System.out.println("Blank votes : " + blankVotes);
    }

    @Override
    public List<VotingOption> getAllVotingOptions(){
        List<VotingOption> list = new ArrayList<>();
        for (VotingOption vOpt : votation.keySet()){
            list.add(vOpt);
        }
        return list;
    }
}
