package com.udemy.angular.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AnimeCharacter implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long idCharacter;

    private String CharacterName;

    private String legend;

    private String category;

    private String strength;

    @Lob
    private byte[] photo;

    private boolean shared;

    @Transient
    private Long idOwner;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public AnimeCharacter() {
    }

    public Long getIdCharacter() {
		return idCharacter;
	}



	public void setIdCharacter(Long idCharacter) {
		this.idCharacter = idCharacter;
	}



	public String getCharacterName() {
		return CharacterName;
	}



	public void setCharacterName(String characterName) {
		CharacterName = characterName;
	}



	public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Long idOwner) {
        this.idOwner = idOwner;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }
}
