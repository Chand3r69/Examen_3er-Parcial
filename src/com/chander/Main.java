package com.chander;


import com.chander.dao.ClienteDao;
import com.chander.dao.CochesDao;
import com.chander.dao.RevisionDao;
import com.chander.model.Cliente;
import com.chander.model.Coche;
import com.chander.model.Revision;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        //Cliente cliente = new Cliente("1450", "Carlos Peres", "Cochabamba", "Av. Ayacucho s/n", 4274869 );
        Cliente laura = new Cliente("1451", "Carlos Peres", "Cochabamba", "Av. Ayacucho s/n", 4152695 );
        Cliente roberto = new Cliente("1452", "Roberto Claros", "Cochabamba", "Av. Junin s/n", 4425639 );
        Cliente lorena = new Cliente("1453", "Lorena Peredo", "Cochabamba", "Av. Heroinas s/n", 4125649 );
        /*Cliente jose = new Cliente("1454", "Jose Jose", "Cochabamba", "calle Sucre s/n", 4526288 );
        Cliente maria = new Cliente("1455", "Maria Vargas", "Cochabamba", "Calle Bolivar s/n", 4785965 );
        Cliente luis = new Cliente("1456-1B", "Luis Villarroel", "Cochabamba", "Av. Blanco Galindo s/n", 4131222 );
        Cliente carmen = new Cliente("1457", "Carmen Peres", "Cochabamba", "Av. Alnina Patino s/n", 413122 );
*/

        //CRUD tabla clientes
         ClienteDao clienteDao = new ClienteDao();

         //CREATE
        //clienteDao.addCliente(cliente);
        clienteDao.addCliente(laura);
        clienteDao.addCliente(roberto);
        clienteDao.addCliente(lorena);
        /*clienteDao.addCliente(jose);
        clienteDao.addCliente(maria);
        clienteDao.addCliente(luis);
        clienteDao.addCliente(carmen);
        */



        //READ

        List<Cliente> clientes = clienteDao.getALLClientes();
        for (int i = 0; i< clientes.size(); i++){
            Cliente cliente = clientes.get(i); ;
            System.out.println(cliente);
        }







        //UPDATE
        Cliente cliente = new Cliente("1450", "Pepito Maravilla", "La Paz", "Av. Cochabamba", 2247885 );

        clienteDao.updateCliente(cliente);

        //DELETE
        clienteDao.deteleCliente("1450");

        clienteDao.deteleCliente("1456-1B");

        ////



        Coche cochex = new Coche("5589LDF","Patito", "2002", "Fuxia", 189520, "1451");
        Coche cochey = new Coche("8744XDS","Golden", "2015", "Golden", 554700, "1452");
        Coche cochez = new Coche("9866RTG","Capibara", "2022", "Cafe", 999000, "1453");

        // CRUD
        CochesDao cocheDao = new CochesDao();

        //CREATE
        cocheDao.addCoches(cochex);
        cocheDao.addCoches(cochey);
        cocheDao.addCoches(cochez);

        //UPDATE
        Coche cocheUp = new Coche("8866ASD", "Gatito", "2000", "Plomo", 789666, "1451" );
        cocheDao.updateCoche(cocheUp);
        Coche cocheUp1 = new Coche("4488LLK", "Rocky", "2005", "Dark", 7745500, "1452");
        cocheDao.updateCoche(cocheUp1);
        //DELETE

        cocheDao.deleteCoche("4488LLK");
        cocheDao.deleteCoche("9866RTG");

        //READ
        List<Coche> coches = cocheDao.getALLCoches();
        for (int i = 0; i < coches.size() ; i++){
            Coche coche = coches.get(i);
            System.out.println(coche);
        }


        /////

        Revision rev1 = new Revision("A0025", "BUENO", "DESGASTADOS", "SUCIO", "8866ASD" );
        Revision rev2 = new Revision("A0034", "REGULAR", "OSCURO", "NO-FRENA", "9866RTG" );

        //CRUD tabla
        RevisionDao revisionDao = new RevisionDao();

        // CREATE

        revisionDao.addRevision(rev1);
        revisionDao.addRevision(rev2);

        //UPDATE
        Revision revisionUP = new Revision( "A0044", "MEJORABLE", "CAMBIAR", "DANADO", "8866ASD" );
        revisionDao.updateRevision(revisionUP);
        Revision revisionUP1 = new Revision( "A0048", "DANADO", "EXPORTAR", "CAMBIAR", "5589LDF" );
        revisionDao.updateRevision(revisionUP1);

        //DELETE
        revisionDao.deleteRevision("A0025");
        revisionDao.deleteRevision("A0048");

        //READ
        List<Revision> revisions = revisionDao.getALLRevision();
        for (int i = 0; i < revisions.size(); i++){
            Revision revision = revisions.get(i);
            System.out.println(revision);

        }


    }

}
