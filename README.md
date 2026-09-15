TP 13 Sérialisation/
├── bin/
├── employees.ser             // Fichier binaire généré par Serializable (Exo 1)
├── chat.ser                  // Fichier binaire généré par Externalizable (Exo 2)
└── src/
    └── com/
        └── example/
            └── tp/
                ├── Employee.java          // Modèle standard Serializable + champ transient
                ├── SerializationUtil.java // Méthodes génériques d'écriture/lecture d'objets
                ├── Main.java              // Programme de test Exo 1
                ├── ChatMessage.java       // Modèle Externalizable à format contrôlé
                ├── ChatHistory.java       // Persistance et restauration de collection
                └── MainChat.java          // Programme de test Exo 2

Exercice 1 — Sérialisation Standard (Serializable)
Interface Marqueur : Déclaration de implements Serializable autorisant la JVM à inspecter et sérialiser l'arbre d'objets par réflexion.

Gestion du Versionnage : Déclaration explicite du private static final long serialVersionUID pour éviter l'exception InvalidClassException lors de modifications de la classe.

Données Sensibles : Utilisation du mot-clé transient sur l'attribut password pour l'exclure du flux binaire (restauré à sa valeur par défaut null à la lecture).

Flux d'Objets : Emploi de ObjectOutputStream.writeObject() et ObjectInputStream.readObject() dans un bloc try-with-resources.


https://github.com/user-attachments/assets/fead80ae-a1cf-46a6-bf06-e626d59602a6

Exercice 2 — Sérialisation Manuelle Avancée (Externalizable)
Contrôle Fin du Flux : Implémentation explicite des méthodes writeExternal(ObjectOutput out) et readExternal(ObjectInput in) pour définir la structure exacte des octets écrits.

Constructeur par défaut : Présence impérative d'un constructeur public sans argument public ChatMessage() {} utilisé par la JVM avant d'appeler readExternal().

Versionnage Applicatif : Écriture d'un entier d'en-tête (FORMAT_VERSION) permettant de garantir la compatibilité ascendante ou de détecter des divergences de version.

Champs Dérivés : Omission volontaire de l'attribut length lors de l'écriture et recalcul dynamique à la volée après lecture du champ message.

https://github.com/user-attachments/assets/e52433a7-8755-4b4a-af22-f89e203d3662

