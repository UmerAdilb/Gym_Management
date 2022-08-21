package services;

import domain.Member;
import domain.Trainer;
import repository.MemberRepository;
import repository.TrainerRepository;

import java.util.List;

public class MemberService {

    public static String[][] getAllMembersForJTable(int length) {
        MemberRepository memberRepository = new MemberRepository();
        List<Member> members = memberRepository.getAllMembers();

        String[][] data = new String[members.size()][length];
        for (int row = 0; row < members.size(); row++) {
            data[row][0] = members.get(row).getId().toString();
            data[row][1] = members.get(row).getName();
            data[row][2] = members.get(row).getGender();
            data[row][3] = members.get(row).getAge().toString();
            data[row][4] = members.get(row).getContact();
            data[row][5] = members.get(row).getAddress();
            data[row][6] = members.get(row).getStatus();
            data[row][7] = members.get(row).getGroupId().toString();


        }
        return data;
    }

    public static boolean addMember(String name, String gender, Integer age, String contact, String address,String status,Long groupId){

        MemberRepository memberRepository = new MemberRepository();
        Member member = new Member(name,gender,age,contact,address,status,groupId);

        if (memberRepository.addMember(member)){

            return true;
        }
        return false;
    }

    public static Member checkMemberbyId(Long id) {
        MemberRepository memberRepository = new MemberRepository();
        Member member = memberRepository.getMemberbyId(id);
        return member;
    }

    public static Boolean updateMember(Long id, String name, String gender, Integer age, String contact, String address, String status, Long groupid) {
      MemberRepository memberRepository = new MemberRepository();
      Boolean update = memberRepository.updateMemberbyId(id,name,gender,age,contact,address,status,groupid);
return update;
    }

    public static Boolean deleteMember(long id) {
        MemberRepository memberRepository = new MemberRepository();
        boolean delete = memberRepository.deleteMemberbyId(id);
        if (delete){return true;
        }
        else {
            return false;
        }
    }
}
