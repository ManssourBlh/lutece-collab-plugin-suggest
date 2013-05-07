/*
 * Copyright (c) 2002-2013, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.digglike.business;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.sql.DAOUtil;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *class  VoteDAO
 *
 */
public class VoteDAO implements IVoteDAO
{
    private static final String SQL_QUERY_SELECT_VOTE_BY_ID_DIGG_SUBMIT = "SELECT id_digg_submit,lutece_user_key " +
        "FROM digglike_vote WHERE id_digg_submit=? ";
    private static final String SQL_QUERY_INSERT = "INSERT INTO " +
        "digglike_vote(id_digg_submit,lutece_user_key) VALUES(?,?) ";
    private static final String SQL_QUERY_COUNT_VOTE_BY_ID_DIGG_SUBMIT_AND_LUTECE_USER_KEY = "SELECT COUNT(id_digg_submit) " +
        "FROM digglike_vote WHERE id_digg_submit= ? and lutece_user_key= ? ";
    private static final String SQL_QUERY_COUNT_VOTE_BY_ID_DIGG_SUBMIT = "SELECT COUNT(id_digg_submit) " +
        "FROM digglike_vote WHERE id_digg_submit= ? ";

    /**
     * Insert a new record in the table.
     *
     * @param vote instance of the Vote object to insert
     * @param plugin the plugin
     */
    public void insert( Vote vote, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, plugin );
        daoUtil.setInt( 1, vote.getIdDiggSubmit(  ) );
        daoUtil.setString( 2, vote.getLuteceUserKey(  ) );
        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the data of all vote associate to the digg submit
     * @param nIdDiggSubmit the DiggSubmit id
     * @param plugin the plugin
     * @return  the list of vote button associated to the vote type  returns them in a  list
     */
    public List<Vote> selectVoteByIdDiggSubmit( int nIdDiggSubmit, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT_VOTE_BY_ID_DIGG_SUBMIT, plugin );
        daoUtil.setInt( 1, nIdDiggSubmit );
        daoUtil.executeQuery(  );

        Vote vote = null;
        List<Vote> listVote = new ArrayList<Vote>(  );

        while ( daoUtil.next(  ) )
        {
            vote = new Vote(  );
            vote.setIdDiggSubmit( daoUtil.getInt( 1 ) );
            vote.setLuteceUserKey( daoUtil.getString( 2 ) );
            listVote.add( vote );
        }

        daoUtil.free(  );

        return listVote;
    }

    /**
     * return the number of vote for a lutece user on diggSubmit
     * @param nIdDiggSubmit the id of the digg submit
     * @param strLuteceUserKey the LuteceUserKey
     * @param plugin the plugin
     * @return the number of vote for a lutece user on diggSubmit
     */
    public int selectCountVoteByIdDiggSubmitAndLuteceUserKey( int nIdDiggSubmit, String strLuteceUserKey, Plugin plugin )
    {
        int nIdCount = 0;
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_COUNT_VOTE_BY_ID_DIGG_SUBMIT_AND_LUTECE_USER_KEY, plugin );
        daoUtil.setInt( 1, nIdDiggSubmit );
        daoUtil.setString( 2, strLuteceUserKey );
        daoUtil.executeQuery(  );

        if ( daoUtil.next(  ) )
        {
            nIdCount = daoUtil.getInt( 1 );
        }

        daoUtil.free(  );

        return nIdCount;
    }

    /**
     * return the number of vote for a lutece user on diggSubmit
     * @param nIdDiggSubmit the id of the digg submit
     * @param plugin the plugin
     * @return the number of vote for a lutece user on diggSubmit
     */
    public int selectCountVoteByIdDiggSubmit( int nIdDiggSubmit, Plugin plugin )
    {
        int nIdCount = 0;
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_COUNT_VOTE_BY_ID_DIGG_SUBMIT, plugin );
        daoUtil.setInt( 1, nIdDiggSubmit );
        daoUtil.executeQuery(  );

        if ( daoUtil.next(  ) )
        {
            nIdCount = daoUtil.getInt( 1 );
        }

        daoUtil.free(  );

        return nIdCount;
    }
}
