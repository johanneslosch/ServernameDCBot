package tech.jlsol.servernamedcbot.features;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.jlsol.servernamedcbot.util.Config;

public class AccountInfoListener extends ListenerAdapter {

  public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
    if (event.getMessage().getContentDisplay().startsWith("!***")) {
      String userID = event.getMessage().getContentDisplay().substring(4);
      if (event.getMessage().getContentDisplay().substring(4).startsWith("*")) {
        userID = userID.replace("*", "");
      }
        event
          .getChannel()
          .sendMessage(
            new EmbedBuilder()
              .setTitle("Account Info")
              .setColor(Color.MAGENTA)
              .setDescription(
                "@" +
                (
                  Objects.requireNonNull(event.getJDA().getUserById(userID))
                ).getAsTag() +
                "\n" +
                "Name: " +
                (
                  Objects.requireNonNull(event.getJDA().getUserById(userID))
                ).getName() +
                "\n" +
                "Bot: " +
                (
                  Objects.requireNonNull(event.getJDA().getUserById(userID))
                ).isBot() +
                "\n" +
                "Account created at: " +
                Objects
                  .requireNonNull(
                    Objects
                      .requireNonNull(
                        event
                          .getJDA()
                          .getGuildById(
                            Config.readConfig("data", "settings", "guildID")
                          )
                      )
                      .getMemberById(userID)
                  )
                  .getTimeCreated()
                  .format(DateTimeFormatter.ISO_LOCAL_DATE) +
                "\n" +
                "Nickname: " +
                Objects
                  .requireNonNull(event.getGuild().getMemberById(userID))
                  .getNickname() +
                "\n"
              )
              .setFooter("Request created at: " + getDateAndTime())
              .setThumbnail(
                Objects
                  .requireNonNull(event.getJDA().getUserById(userID))
                  .getAvatarUrl()
              )
              .setAuthor(event.getAuthor().getName())
              .build()
          )
          .queue();
    }
  }

  private String getDateAndTime() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy ");
    LocalDateTime now = LocalDateTime.now();
    return dtf.format(now);
  }
}
