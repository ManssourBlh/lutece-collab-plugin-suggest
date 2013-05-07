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
import fr.paris.lutece.portal.service.spring.SpringContextService;

import java.util.List;


/**
 *
 *class voteHome
 *
 */
public final class VoteHome
{
    // Static variable pointed at the DAO instance
    private static IVoteDAO _dao = (IVoteDAO) SpringContextService.getPluginBean( "digglike", "digglike.voteDAO" );

    /**
     * Private constructor - this class need not be instantiated
     */
    private VoteHome(  )
    {
    }

    /**
     * Creation of an instance of vote
     *
     * @param vote The instance of the Digg which contains the informations to store
     * @param plugin the Plugin
     *
     */
    public static void create( Vote vote, Plugin plugin )
    {
        _dao.insert( vote, plugin );
    }

    /**
     * Load the data of all vote associate to the digg submit
     * @param nIdDiggSubmit the id of the digg submit
     * @param plugin the plugin
     * @return  the list of vote button associated to the vote type  returns them in a  list
     */
    public static List<Vote> getListVoteByIdDiggSubmit( int nIdDiggSubmit, Plugin plugin )
    {
        return _dao.selectVoteByIdDiggSubmit( nIdDiggSubmit, plugin );
    }

    /**
     * return the number of vote for a lutece user on diggSubmit
     * @param nIdDiggSubmit the id of the digg submit
     * @param strLuteceUserKey the LuteceUserKey
     * @param plugin the plugin
     * @return the number of vote for a lutece user on diggSubmit
     */
    public static int getUserNumberVoteOnDiggSubmit( int nIdDiggSubmit, String strLuteceUserKey, Plugin plugin )
    {
        return _dao.selectCountVoteByIdDiggSubmitAndLuteceUserKey( nIdDiggSubmit, strLuteceUserKey, plugin );
    }

    /**
     * return the number of vote for a lutece user on diggSubmit
     * @param nIdDiggSubmit the id of the digg submit
     * @param plugin the plugin
     * @return the number of vote for a lutece user on diggSubmit
     */
    public static int getNumberVoteDiggSubmit( int nIdDiggSubmit, Plugin plugin )
    {
        return _dao.selectCountVoteByIdDiggSubmit( nIdDiggSubmit, plugin );
    }
}
