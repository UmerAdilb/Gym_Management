package services;

import domain.Group;
import domain.Member;
import repository.GroupRepository;
import repository.MemberRepository;


import java.util.List;

public class GroupService {

    public static String[][] getallgroups(int length) {
        GroupRepository groupRepository = new GroupRepository();
        List<Group> group = groupRepository.getAllGroups();

        String[][] data = new String[group.size()][length];
        for (int row = 0; row < group.size(); row++) {
            data[row][0] = group.get(row).getId().toString();
            data[row][1] = group.get(row).getName();
            data[row][2] = group.get(row).getTiming();
            data[row][3] = group.get(row).getType();
            data[row][4] = group.get(row).getTrainerId().toString();

        }
        return data;
    }

    public static Group checkGroupbyId(Long id) {
        GroupRepository groupRepository = new GroupRepository();
        Group group = groupRepository.getGroupbyId(id);
        return group;
    }

    public static Boolean updateGroup(Long id, String name, String timing, String type, Long trainerid) {
        GroupRepository groupRepository = new GroupRepository();
        Boolean update = groupRepository.updateGroupbyId(id, name, timing, type, trainerid);
        return update;
    }

    public static boolean addGroup(String name, String timing, String type, Long trainerid) {

        GroupRepository groupRepository = new GroupRepository();
        Group group = new Group(name, timing, type, trainerid);

        if (groupRepository.addGroup(group)) {

            return true;
        }
        return false;
    }

    public static Boolean deleteGroup(long id) {
        GroupRepository groupRepository = new GroupRepository();
        boolean delete = groupRepository.deleteGroupbyId(id);
        if (delete) {
            return true;
        } else {
            return false;
        }
    }

    public static Long checkGroupNAme(String groupName) {
        GroupRepository groupRepository = new GroupRepository();
        List<Group> group = groupRepository.getAllGroups();

        Long gid = group.stream().filter(fl -> fl.getName().equalsIgnoreCase(groupName)).findAny().orElse(null).getId();


        return gid;

    }

    public static String[][] getGroupsForUSER(int length) {
        GroupRepository groupRepository = new GroupRepository();
        List<Group> group = groupRepository.getGroupsForuserPanel();

        String[][] data = new String[group.size()][length];
        for (int row = 0; row < group.size(); row++) {

            data[row][0] = group.get(row).getName();
            data[row][1] = group.get(row).getTiming();
            data[row][2] = group.get(row).getType();
            data[row][3] = group.get(row).getTrainerName();

        }
        return data;
    }
}