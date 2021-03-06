/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import java.util.*;

import javax.persistence.*;





import com.avaje.ebean.*;

@Entity
@Table(schema="core", name="core.tissue_taxonomy_synonym")
public class TissueTaxonomySynonym  {
	
	@Id
	public Long tissueTaxonomySynonymId;
	
	//public int tissueTaxonomySynonymId;
    public TissueTaxonomy tissueTaxonomy;
    public String synonym;

    public Long getTissueTaxonomySynonymId() {
        return tissueTaxonomySynonymId;
    }

    public void setTissueTaxonomySynonymId(Long tissueTaxonomySynonymId) {
        this.tissueTaxonomySynonymId = tissueTaxonomySynonymId;
    }

    public TissueTaxonomy getTissueTaxonomy() {
        return tissueTaxonomy;
    }

    public void setTissueTaxonomy(TissueTaxonomy tissueTaxonomy) {
        this.tissueTaxonomy = tissueTaxonomy;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }
}
