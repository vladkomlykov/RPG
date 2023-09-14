import java.util.*;

public class Game {
    private HashMap<String, String> users = new HashMap<>();
    private HashMap<String, List<Character>> userCharacters = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void logIn() {
        loadData();

        System.out.print("Вход\nВведите логин: ");
        String enterUName = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String enterPassword = scanner.nextLine();

        if (users.containsKey(enterUName) && enterPassword.equals(users.get(enterUName))) {
            System.out.println("Добро пожаловать " + enterUName + "!");
            manageCharacters(enterUName);
        } else {
            System.out.println("Неверный пароль или логин");
            logIn();
        }
    }

    private void manageCharacters(String userName) {
        List<Character> characters = userCharacters.get(userName);
        if (characters == null) {
            characters = new ArrayList<>();
            userCharacters.put(userName, characters);
        }

        while (true) {
            System.out.println("1. Создать нового персонажа");
            System.out.println("2. Вывести список персонажей");
            System.out.println("3. Играть");
            System.out.println("4. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (characters.size() < 3) {
                        createCharacter(userName, characters);
                    } else {
                        System.out.println("Слишком много героев!");
                    }
                    break;
                case "2":
                    displayCharacters(userName, characters);
                    break;
                case "3":
                    if (characters.isEmpty()) {
                        System.out.println("У вас нет персонажей. Создайте персонажа сначала.");
                    } else {
                        playGame(userName, characters);
                    }
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте еще раз.");
                    break;
            }
        }
    }

    private void playGame(String userName, List<Character> characters) {
        System.out.println("Выберите персонажа для игры:");
        for (int i = 0; i < characters.size(); i++) {
            System.out.println((i + 1) + ". " + characters.get(i).nameOfCharacter);
        }

        int characterChoice = Integer.parseInt(scanner.nextLine()) - 1;

        if (characterChoice >= 0 && characterChoice < characters.size()) {
            Character selectedCharacter = characters.get(characterChoice);
            System.out.println("Вы выбрали персонажа: " + selectedCharacter.nameOfCharacter);

            while (true) {
                System.out.println("Выберите умение:");
                System.out.println("1. Обычная атака");
                System.out.println("2. Сильная атка");
                System.out.println("3. Супер атака");
                System.out.println("4. Выйти из игры");

                String abilityChoice = scanner.nextLine();

                switch (abilityChoice) {
                    case "1":
                    case "2":
                    case "3":
                        int abilityNumber = Integer.parseInt(abilityChoice);
                        if (selectedCharacter.isAbilityReady(abilityNumber)) {
                            System.out.println("Вы использовали Умение " + abilityNumber);
                            selectedCharacter.useAbility(abilityNumber);
                        } else {
                            System.out.println("Умение " + abilityNumber + " ещё не готово.");
                        }
                        break;
                    case "4":
                        return;
                    default:
                        System.out.println("Неверный выбор, попробуйте еще раз.");
                        break;
                }
            }
        } else {
            System.out.println("Неверный выбор персонажа.");
        }
    }

    private void createCharacter(String userName, List<Character> characters) {
        System.out.print("Выберите тип персонажа:\n1. охотник\n2. воин\n3. маг\nВведите число: ");
        String selectedCharacter = scanner.nextLine();

        Character character = new Character();
        System.out.print("Введите имя персонажа: ");
        character.nameOfCharacter = scanner.nextLine();

        character.abilities.put(1, new Ability("Умение 1", 3));
        character.abilities.put(2, new Ability("Умение 2", 5));
        character.abilities.put(3, new Ability("Умение 3", 7));

        characters.add(character);

        System.out.println("Персонаж " + character.nameOfCharacter + " создан.");
    }

    private void displayCharacters(String userName, List<Character> characters) {
        if (characters.isEmpty()) {
            System.out.println("У вас пока нет персонажей.");
        } else {
            System.out.println("Список ваших персонажей:");
            for (Character character : characters) {
                System.out.println("Имя: " + character.nameOfCharacter);
            }
        }
    }

    private void loadData() {
        users.put("YngCharm", "JavaIMBA");
        users.put("IvanZolo2004", "KashaKasha");
        users.put("ShelbyTomas", "pickyBlinders");
    }
}

