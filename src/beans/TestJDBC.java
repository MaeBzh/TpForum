package beans;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class TestJDBC {
    /* La liste qui contiendra tous les résultats de nos essais */
    private List<String> messages = new ArrayList<String>();


        public List<String> executerTests( HttpServletRequest request ) {
            /* Chargement du driver JDBC pour MySQL */
            try {
                messages.add( "Chargement du driver..." );
                Class.forName( "com.mysql.jdbc.Driver" );
                messages.add( "Driver chargé !" );
            } catch ( ClassNotFoundException e ) {
                messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                        + e.getMessage() );
            }

            /* Connexion à la base de données */
            String url = "jdbc:mysql://localhost:3306/forum?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            String utilisateur = "forum";
            String motDePasse = "forum";
            Connection connexion = null;
            Statement statement = null;
            ResultSet resultat = null;
            try {
                messages.add( "Connexion à la base de données..." );
                connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
                messages.add( "Connexion réussie !" );

                /* Création de l'objet gérant les requêtes */
                statement = connexion.createStatement();
                messages.add( "Objet requête créé !" );

                /* Exécution d'une requête de lecture */
                resultat = statement.executeQuery( "SELECT user_id, mail, password  nom FROM user;" );
                messages.add( "Requête \"SELECT user_id, password, password, nom FROM user;\" effectuée !" );

                /* Récupération des données du résultat de la requête de lecture */
                while ( resultat.next() ) {
                    int idUtilisateur = resultat.getInt( "user_id" );
                    String emailUtilisateur = resultat.getString( "mail" );
                    String motDePasseUtilisateur = resultat.getString( "password" );
                    String nomUtilisateur = resultat.getString( "nom" );
                    /* Formatage des données pour affichage dans la JSP finale. */
                    messages.add( "Données retournées par la requête : id = " + idUtilisateur + ", email = " + emailUtilisateur
                            + ", password = "
                            + motDePasseUtilisateur + ", nom = " + nomUtilisateur + "." );
                }
            } catch ( SQLException e ) {
                messages.add( "Erreur lors de la connexion : <br/>"
                        + e.getMessage() );
            } finally {
                messages.add( "Fermeture de l'objet ResultSet." );
                if ( resultat != null ) {
                    try {
                        resultat.close();
                    } catch ( SQLException ignore ) {
                    }
                }
                messages.add( "Fermeture de l'objet Statement." );
                if ( statement != null ) {
                    try {
                        statement.close();
                    } catch ( SQLException ignore ) {
                    }
                }
                messages.add( "Fermeture de l'objet Connection." );
                if ( connexion != null ) {
                    try {
                        connexion.close();
                    } catch ( SQLException ignore ) {
                    }
                }
            }

            return messages;
        }
}