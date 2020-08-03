package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.jlsol.servernamedcbot.util.Logger;

import javax.annotation.Nonnull;

public class VoiceListeners extends ListenerAdapter {

    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent event) {
        if (!event.getGuild().getTextChannels().isEmpty()) {
            event.getGuild().createTextChannel(event.getChannelJoined().getName() + "-mute").
                    setParent(event.getChannelJoined().getParent()).setName(event.getChannelJoined().getName() + "-mute").queue();
        }
        else {
            event.getGuild().createTextChannel(event.getChannelJoined().getName() + "-mute").
                    setParent(event.getChannelJoined().getParent()).setName(event.getChannelJoined().getName() + "-mute").queue();
        }
    }

    public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent event) {
        /*
        TODO: channel join not created
        TODO: channel delete

         */
        if(!event.getChannelLeft().getMembers().isEmpty()){
            event.getGuild().createTextChannel(event.getChannelJoined().getName() + "-mute").
                        setParent(event.getChannelJoined().getParent()).setName(event.getChannelJoined().getName() + "-mute").queue();
            event.getGuild().getTextChannelsByName(event.getChannelLeft().getName() + "-mute", true).get(0)
                        .getManager().getChannel().delete()
                        .reason(String.format("All users from %s left", event.getChannelLeft().getName())).queue();
        }

    }

    //TODO: channel delete
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event) {
        if(event.getChannelLeft().getMembers().isEmpty()) {
            if (event.getGuild().getTextChannels().contains(event.getChannelLeft().getName() + "-mute")) {
                event.getGuild().getTextChannelsByName(event.getChannelLeft().getName() + "-mute", true).get(0)
                        .getManager().getChannel().delete()
                        .reason(String.format("All users from %s left", event.getChannelLeft().getName())).queue();
            }
        }
    }
}
