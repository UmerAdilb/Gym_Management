package services;

import domain.Trainer;
import repository.TrainerRepository;

import java.util.List;

public class TrainerService {
    public static String[][] getAllTrainersForJTable(int length) {
        TrainerRepository trainerRepository = new TrainerRepository();
        List<Trainer> trainerLi = trainerRepository.GetAllTrainers();

        String[][] data = new String[trainerLi.size()][length];
        for (int row = 0; row < trainerLi.size(); row++) {
            data[row][0] = trainerLi.get(row).getId().toString();
            data[row][1] = trainerLi.get(row).getName();
            data[row][2] = trainerLi.get(row).getGender();
            data[row][3] = trainerLi.get(row).getAge().toString();
            data[row][4] = trainerLi.get(row).getContact();
            data[row][5] = trainerLi.get(row).getAddress();

        }
        return data;
    }

    public static boolean addTrainer(String name, String gender, Integer age, String contact, String address){

        TrainerRepository trainerRepository = new TrainerRepository();
        List<Trainer> trainerLi = trainerRepository.GetAllTrainers();
        Trainer train = trainerLi.stream().filter(f->f.getName().equalsIgnoreCase(name)
        ).findAny().orElse(null);

        if (train == null){
            Trainer trainer = new Trainer(name,gender,age,contact,address);
            trainerRepository.addTrainer(trainer);
            return true;
        }
        return false;
    }

    public static Boolean DeleteTrainer(Long id) {
        TrainerRepository trainerRepository = new TrainerRepository();
        Boolean tr = trainerRepository.deleteTrainerThroughID(id);

        if (tr){return  true;}
        return false;}

    public static Trainer searchTrainer(Long id) {
        TrainerRepository trainerRepository = new TrainerRepository();
        Trainer train = trainerRepository.getTrainersthroughName(id);

        return train;
    }

    public static Boolean TrainerEdit(String name, String gender, Integer age, String contact, String address, Long id) {
        TrainerRepository trainerRepository = new TrainerRepository();
        Boolean tr =  trainerRepository.UpdateTrainer(name,gender,age,contact,address,id);
        if (tr){return true;}
        return false;}
}
