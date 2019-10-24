package com.udithshalinda.demo.input_blogs;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class InputBlog {
    @Id
    public ObjectId id;

    public String testId;
    public String header;
    public String blog;
    public String createrId;
    public String coverImageId;
    public List<String> upVoters = new ArrayList<>();
    public List<String> downVoters = new ArrayList<>();


    public InputBlog(String header,String blog,String createrId,String coverImageId) {
        this.header = header;
        this.blog = blog;
        this.createrId= createrId;
        this.coverImageId = coverImageId;
    }
    public void setId(ObjectId id){
        this.id = id;
    }

    public void addUpVoters(String userId){
        this.upVoters.add(userId);
    }
    public void addDownVoters(String userId){
        this.downVoters.add(userId);
    }

    public boolean checkDownVoter(String user){
        if(this.downVoters != null){
            System.out.println("down not null");
            System.out.println(this.downVoters.contains(user));
            return this.downVoters.contains(user);
        }else{
            return false;
        }
    }
    public boolean checkUpVoter(String user){
        if(this.upVoters != null){
            System.out.println("up not null");
            System.out.println(this.upVoters.contains(user));
            return this.upVoters.contains(user);
        }else{
            return false;
        }
    }
    public void removeUpVOter(String voter){
        this.upVoters.remove(voter);
    }
    public void removeDownVOter(String voter){
        this.downVoters.remove(voter);
    }
}
