package data;
import exceptions.NifIsNullException;

import exceptions.NifNotValidException;

final public class Nif {
    private final String Nif;

    public Nif(String nif) throws NifNotValidException, NifIsNullException {
        if(nif == null){
            throw new NifIsNullException("Nif is null");
        }
        else if(nifIsValid(nif)){
            this.Nif = nif;
        }
        else{
            throw new NifNotValidException("Nif " + nif + " is not valid <8 numbers + 1 letter>");
        }
    }

    private boolean nifIsValid(String nif) { //abcdefgh1

        if(nif.length() != 9){
            return false;
        }

        for (int i = 0; i < 8; i++) {
            Character character = nif.charAt(i);
            if(!Character.isDigit(character)){
                return false;
            }
        }
        Character character = nif.charAt(8);
        return Character.isLetter(character);
    }

    public String getNif(){
        return this.Nif;
    }
}
