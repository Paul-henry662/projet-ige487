package meca;

import java.sql.*;

/**
 * Gestionnaire d'une connexion avec une BD relationnelle via JDBC.<br><br>
 * 
 * Cette classe ouvre une connexion avec une BD via JDBC.<br>
 * La m�thode serveursSupportes() indique les serveurs support�s.<br>
 * <pre>
 * Pr�-condition
 *   Le driver JDBC appropri� doit �tre accessible.
 * 
 * Post-condition
 *   La connexion est ouverte en mode autocommit false et s�rialisable, 
 *   (s'il est support� par le serveur).
 * </pre>
 * <br>
 * IFT287 - Exploitation de BD relationnelles et OO
 * 
 * @author Marc Frappier - Universit� de Sherbrooke
 * @version Version 2.0 - 13 novembre 2004
 * 
 * 
 * @author Vincent Ducharme - Universit� de Sherbrooke
 * @version Version 3.0 - 21 mai 2016
 */
public class Connexion
{
    private Connection conn;

    /**
     * Ouverture d'une connexion en mode autocommit false et s�rialisable (si
     * support�)
     * 
     * @param serveur Le type de serveur SQL � utiliser (Valeur : local, dinf).
     * @param bd      Le nom de la base de donn�es sur le serveur.
     * @param user    Le nom d'utilisateur � utiliser pour se connecter � la base de donn�es.
     * @param pass    Le mot de passe associ� � l'utilisateur.
     */
    public Connexion(String serveur, String bd, String user, String pass)
            throws MecaException, SQLException
    {
        Driver d;
        try
        {
            d = (Driver)Class.forName("org.postgresql.Driver").newInstance();
            DriverManager.registerDriver(d);
            
            if (serveur.equals("local"))
            {
                conn = DriverManager.getConnection("jdbc:postgresql:" + bd, user, pass);
            }
            else if (serveur.equals("dinf"))
            {
                conn = DriverManager.getConnection("jdbc:postgresql://bd-info2.dinf.usherbrooke.ca:5432/" + bd + "?ssl=true&sslmode=require", user, pass);
            }
            else
            {
                throw new MecaException("Serveur inconnu");
            }

            // Mise en mode de commit manuel
            conn.setAutoCommit(false);

            // Mise en mode s�rialisable, si possible
            // (plus haut niveau d'integrit� pour l'acc�s concurrent aux donn�es)
            DatabaseMetaData dbmd = conn.getMetaData();
            if (dbmd.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE))
            {
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                System.out.println("Ouverture de la connexion en mode s�rialisable :\n"
                        + "Connect� sur la BD postgreSQL "
                        + bd + " avec l'utilisateur " + user);
            }
            else
            {
                System.out.println("Ouverture de la connexion en mode read committed (default) :\n"
                        + "Connect� sur la BD postgreSQL "
                        + bd + " avec l'utilisateur " + user);
            }
        }
        catch (SQLException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
            throw new MecaException("JDBC Driver non instanci�");
        }
    }

    /**
     * Fermeture d'une connexion
     */
    public void fermer() throws SQLException
    {
        conn.rollback();
        conn.close();
        System.out.println("Connexion ferm�e " + conn);
    }

    /**
     * Commit
     */
    public void commit() throws SQLException
    {
        conn.commit();
    }

    public void setIsolationReadCommited() throws SQLException
    {
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    }

    /**
     * Rollback
     */
    public void rollback() throws SQLException
    {
        conn.rollback();
    }

    /**
     * Retourne la Connection JDBC
     */
    public Connection getConnection()
    {
        return conn;
    }

    public void setAutoCommit(boolean m) throws SQLException
    {
        conn.setAutoCommit(false);
    }

    /**
     * Retourne la liste des serveurs support�s par ce gestionnaire de
     * connexions
     */
    public static String serveursSupportes()
    {
        return "local : PostgreSQL install� localement\n"
             + "dinf  : PostgreSQL install� sur les serveurs du d�partement\n";
    }
}