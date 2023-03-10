package br.com.caua.aula03.control;

import java.util.ArrayList;

import br.com.caua.aula03.model.MPessoa;

public class DAOPessoa {

    private static ArrayList<MPessoa> TPessoa;

    private static DAOPessoa FDAOPessoa;

    //Instacia
    public static DAOPessoa getFDAOPessoa() {
        if (FDAOPessoa == null) {
            FDAOPessoa = new DAOPessoa();
            TPessoa    = new ArrayList<>();
        }
        return FDAOPessoa;
    }

    //Insert
    public Boolean insert(MPessoa prModel) {
        if(prModel != null) {
            this.TPessoa.add(prModel);
            return true;
        }
        return false;
    }

    //Update
    public Boolean update(MPessoa prModel, String prNome) {
        for (MPessoa tp : TPessoa) {
            if(tp.getFNOME() == prNome) {

                tp.setFNOME (prModel.getFNOME());
                tp.setFEMAIL(prModel.getFEMAIL());

                return true;
            }
        }
        return false;
    }

    //Delete
    public Boolean delete(MPessoa prModel, String prNome) {
        for (MPessoa tp : TPessoa) {
            if(tp.getFNOME() == prNome) {
                TPessoa.remove(tp);
                return true;
            }
        }
        return false;
    }

    //Select
    public ArrayList<MPessoa> getList(){
        return TPessoa;
    }

}
